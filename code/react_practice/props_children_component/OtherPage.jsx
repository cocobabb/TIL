import AdminPage from "./AdminPage";
import ManagerPage from "./ManagerPage";
import UserPage from "./UserPage";

export default function OtherPage({ userType, children }) {
  const text = userType;
  const Checked = children;

  switch (text) {
    case "admin":
      return <AdminPage>{Checked}</AdminPage>;

    case "manager":
      return <ManagerPage>{Checked}</ManagerPage>;

    case "user":
      return <UserPage>{Checked}</UserPage>;
  }
}
