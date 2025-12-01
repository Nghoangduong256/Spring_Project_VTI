
import { BrowserRouter, Routes, Route, Link, NavLink, Navigate } from 'react-router-dom';
import './components/bootstrap/App.css';
import AccountPage from './pages/account/AccountPage';
import DepartmentPage from './pages/department/DepartmentPage';
import LoginPage from './components/demo/DemoLoginPage';
import { AuthProvider, useAuth } from './context/AuthContext';
import RequireAuth from './components/RequireAuth';
import MainLayout from './components/MainLayout';
import '@fortawesome/fontawesome-free/css/all.min.css';



function App() {
  return (
    // <AuthProvider>
    <BrowserRouter>
      <Routes>
        {/* <Route path='/' element={<Navigate to='/login' />} /> */}

        {/* <Route path='/login' element={<LoginPage />} /> */}
        {/* <Route path='/login' element={<DemoLogin />} /> */}

        {/* Bọc các trang cần layout bên trong MainLayout */}
        <Route path="/" element={<MainLayout />}>
          <Route path="/department" element={<DepartmentPage />} />
          <Route path="/account" element={<AccountPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
    // </AuthProvider>
  );
}

export default App;
