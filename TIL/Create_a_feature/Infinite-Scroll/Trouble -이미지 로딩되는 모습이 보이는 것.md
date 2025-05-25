## 문제 상황
이미지 로딩되는 동안 스켈레톤이 보이도록 설정하려고 아래와 같이 코드를 작성했는데 스켈레톤이 보이다가 이미지로 바뀌는 과정 중 이미지 태그가 먼저 렌더링 되고 이미지 로드가 되는 동안 빈 화면이 보이게 됨
즉, 스켈레톤 -> 이미지 과정 중 이미지 로딩 과정이 보이게 됨 => 스켈레톤 설정한 의미가 없어짐..


```javascript
import { useEffect, useState } from "react";
import axios from "axios";
import { useInView } from "react-intersection-observer";

// Skeleton: 로딩 중일 때 보여줄 UI
function Skeleton() {
  return <div className="h-screen w-full animate-pulse bg-gray-300" />;
}

// LazyImage: 이미지가 화면에 보일 때만 로드 + Skeleton UI + loading="lazy"
function LazyImage({ src, alt }) {
  const { ref, inView } = useInView({
    triggerOnce: true,
    threshold: 0.1,
  });

  return (
    <div
      ref={ref}
      className="mb-4 flex h-dvh w-full items-center justify-center"
    >
      {inView ? (
        <img
          src={src}
          alt={alt}
          loading="lazy" // ✅ 브라우저 Lazy Loading
          className="h-full w-full object-cover opacity-100 transition-opacity duration-500"
        />
      ) : (
        <Skeleton />
      )}
    </div>
  );
}

// App: 무한 스크롤 + Lazy Load 이미지 목록
export default function App() {
  const [images, setImages] = useState([]);
  const [cursor, setCursor] = useState(null);
  const [hasMore, setHasMore] = useState(true);
  const [isLoading, setIsLoading] = useState(false);

  const { ref: bottomRef, inView } = useInView({
    threshold: 1.0,
  });

  const loadImages = async () => {
    if (isLoading || !hasMore) return;

    setIsLoading(true);

    const params = new URLSearchParams();
    if (cursor !== null) params.append("cursorId", cursor);
    params.append("size", "1");

    try {
      const res = await axios.get(
        import.meta.env.VITE_API_URL + /api/images?${params},
      );
      const data = res.data;
      console.log(data);
      setImages((prev) => {
        const existingIds = new Set(prev.map((img) => img.id));
        const newItems = data.items.filter((img) => !existingIds.has(img.id));
        return [...prev, ...newItems];
      });

      if (data.nextCursor) {
        setCursor(data.nextCursor);
      } else {
        setHasMore(false);
      }
    } catch (err) {
      console.error("이미지 로딩 실패:", err);
    } finally {
      setIsLoading(false);
    }
  };

  // 최초 로딩
  useEffect(() => {
    loadImages();
  }, []);

  // 하단 감지 시 추가 로딩
  useEffect(() => {
    if (inView) {
      loadImages();
    }
  }, [inView]);

  return (
    <div className="mx-auto max-w-2xl py-8">
      <h2 className="mb-6 text-center text-2xl font-semibold">
        📷 Lazy Load 이미지
      </h2>

      {images.map((img) => (
        <LazyImage key={img.id} src={img.imageUrl} alt={img.description} />
      ))}

      {hasMore && (
        <div ref={bottomRef} className="py-8 text-center text-gray-500">
          {isLoading ? "loading" : "Scroll down to load more..."}
        </div>
      )}
    </div>
  );
}
```

## 해결
`inView`: ref 요소가 Viewport에 보이는 상태인지 판별하는 boolean 값
 
 ref가 Viewport에 보이게 되면서 inView가 true ➡️ 스켈레톤 태그에서 img 태그로 전환됨 ➡️ 이미 img태그로 전환 되어 태그는 렌더링 되었지만 아직 이미지는 로딩 중 

위와 같은 상황이였기 때문에 이미지 로딩을 판별하는 상태 변수를 생성하여 이미지가 로딩 되기 전까지는 스켈레톤 태그를 보이게 하고 이미지가 로딩이 끝나면 img 태그로 전환 되게 함

```javascript
function LazyImage({ src, alt }) {
  // 아래에서 설정된 useInView 값 가져오기
  const { ref, inView } = useInView({
    triggerOnce: true, // ref 한번만 감지하고 더이상 관찰x
    threshold: 0.1, // ref의 10%이상이 화면에 보이면 inView속성이 true로 설정됨
  });

  // 이미지 로드를 판별하는 상태 값 : 이미지가 로드 될 때까지 스켈레톤을 보여주기 위한 상태 값
  const [loaded, setLoaded] = useState(false);

  return (
    <div
      ref={ref}
      className="relative mb-4 flex h-dvh w-full items-center justify-center"
    >
      {/* Skeleton은 이미지가 로드되기 전까지만 보여줌 */}
      {!loaded && <Skeleton />}

      {inView && (
        <img
          src={src}
          alt={alt}
          onLoad={() => setLoaded(true)}
          className={`absolute h-full w-full object-cover opacity-100`}
        />
      )}
    </div>
  );
}
```

## 해결 전체 코드

```javascript
import { useEffect, useState } from "react";
import axios from "axios";
import { useInView } from "react-intersection-observer";

// Skeleton: 로딩 중일 때 보여줄 UI
function Skeleton() {
  return <div className="h-screen w-full animate-pulse bg-gray-300" />;
}

// LazyImage: 이미지가 화면에 보일 때만 로드하고 로드 전까지는 Skeleton UI
function LazyImage({ src, alt }) {
  // 아래에서 설정된 useInView 값 가져오기
  const { ref, inView } = useInView({
    triggerOnce: true, // 한번만 감지하고 더이상 관찰x
    threshold: 0.1, // ref의 10%이상이 화면에 보이면 inView속성이 true로 설정됨
  });

  // 이미지 로드를 판별하는 상태 값 : 이미지가 로드 될 때까지 스켈레톤을 보여주기 위한 상태 값
  const [loaded, setLoaded] = useState(false);

  return (
    <div
      ref={ref}
      className="relative mb-4 flex h-dvh w-full items-center justify-center"
    >
      {/* Skeleton은 이미지가 로드되기 전까지만 보여줌 */}
      {!loaded && <Skeleton />}

      {inView && (
        <img
          src={src}
          alt={alt}
          onLoad={() => setLoaded(true)}
          className={`absolute h-full w-full object-cover opacity-100`}
        />
      )}
    </div>
  );
}

// App: 무한 스크롤 + Lazy Load 이미지 목록
export default function App() {
  const [images, setImages] = useState([]);
  const [cursor, setCursor] = useState(null);
  const [hasMore, setHasMore] = useState(true);
  const [isLoading, setIsLoading] = useState(false);

  const { ref: bottomRef, inView } = useInView({
    threshold: 1.0,
  });

  const loadImages = async () => {
    // 로딩 중이거나 남은 이미지 없으면 이미지 요청 하지않음
    if (isLoading || !hasMore) return;

    setIsLoading(true);

    // URL을 가져와 쿼리스트링 추가
    const params = new URLSearchParams();
    if (cursor !== null) params.append("cursorId", cursor);
    params.append("size", "1");

    try {
      const res = await axios.get(
        import.meta.env.VITE_API_URL + `/api/images?${params}`,
      );
      const data = res.data;
      console.log(data);
      setImages((prev) => {
        // 기존에 불러온 id의 이미지는 빼고 추가하기 위한 설정
        const existingIds = new Set(prev.map((img) => img.id));
        const newItems = data.items.filter((img) => !existingIds.has(img.id));
        return [...prev, ...newItems];
      });

      // 남은 이미지가 있는지 판별하는 cursor값
      if (data.nextCursor) {
        setCursor(data.nextCursor);
      } else {
        setHasMore(false);
      }
    } catch (err) {
      console.error("이미지 로딩 실패:", err);
    } finally {
      setIsLoading(false);
    }
  };

  // 최초 로딩
  useEffect(() => {
    loadImages();
  }, []);

  // 하단 감지 시 추가 로딩
  useEffect(() => {
    if (inView) {
      loadImages();
    }
  }, [inView]);

  return (
    <div className="mx-auto max-w-2xl py-8">
      <h2 className="mb-6 text-center text-2xl font-semibold">
        🐕🐕 Lazy Load 이미지
      </h2>

      {images.map((img) => (
        <LazyImage key={img.id} src={img.imageUrl} alt={img.description} />
      ))}

      {hasMore && (
        <div ref={bottomRef} className="py-8 text-center text-gray-500">
          {isLoading ? "loading" : "Scroll down to load more..."}
        </div>
      )}
    </div>
  );
}

```