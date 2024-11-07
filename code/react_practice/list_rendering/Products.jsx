import React from "react";

export default function Products() {
  const products = [
    { id: 1, name: "노트북", price: 55000 },
    { id: 2, name: "마우스", price: 15000 },
    { id: 3, name: "키보드", price: 45000 },
    { id: 4, name: "마우스패드", price: 8000 },
    { id: 5, name: "모니터", price: 150000 },
  ];
  const renderProducts = products
    .filter((product) => product.price >= 30000)
    .map((ob) => {
      const { id, name, price } = ob;
      return (
        <div>
          id:{id} name:{name} price:{price}
        </div>
      );
    });

  return renderProducts;
}
