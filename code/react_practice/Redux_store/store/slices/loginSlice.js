import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  isLogin: false,
  // 확장성 고려해서 객체로 만들기
  // isAdmin :false
};

const loginSlice = createSlice({
  name: "isLogin",
  initialState,
  reducers: {
    login: (state, action) => {
      state.isLogin = true;
    },
    logout: (state, action) => {
      state.isLogin = false;
    },
  },
});

export const { login, logout } = loginSlice.actions;
export default loginSlice.reducer;
