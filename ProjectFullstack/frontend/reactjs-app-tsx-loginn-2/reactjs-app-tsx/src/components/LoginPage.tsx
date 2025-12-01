import React, { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import {
    Form,
    FormGroup,
    Label,
    Input,
    Button,
    Alert,
    FormFeedback,
    FormText,
} from 'reactstrap';
import { useAuth } from '../context/AuthContext';
import { accountService } from '../api/accountService';

const BackgroundImage =
    'https://images8.alphacoders.com/136/thumb-1920-1363709.png';
const Logo =
    'https://vti.com.vn/wp-content/uploads/2025/03/Logo-white.svg';

const LoginPage: React.FC = () => {
    const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);

    const [message, setMessage] = useState<string | null>(null);
    const [remember, setRemember] = useState(false);
    const { login } = useAuth();
    const location = useLocation();
    const from = (location.state as any)?.from?.pathname ?? '/account';

    function validateEmail(e: string) {
        return /\S+@\S+\.\S+/.test(e);
    }

    async function handleSubmit(e: React.FormEvent) {
        e.preventDefault();
        setError(null);
        setMessage(null);

        if (!email || !password) {
            setError('Vui lòng nhập đầy đủ email và mật khẩu');
            return;
        }
        if (!validateEmail(email)) {
            setError('Vui lòng nhập địa chỉ email hợp lệ');
            return;
        }

        try {
            setLoading(true);
            // Use the new accountService.login API which queries by email and validates password when present.
            const matched = await accountService.login(email, password);
            if (!matched) {
                setError('Email hoặc mật khẩu không đúng');
                return;
            }

            setMessage(`Chào mừng trở lại, ${matched.fullName ?? matched.userName ?? matched.email}`);

            // set global auth user so app can show logout and user info
            login(matched);

            // Redirect to the page the user originally tried to access (or /account)
            setTimeout(() => navigate(from), 700);
        } catch (err: any) {
            setError(err?.message || 'Đăng nhập thất bại');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div
            className="login-wrapper"
            style={{
                backgroundImage: `url(${BackgroundImage})`,
                backgroundSize: 'cover',
                backgroundPosition: 'center',
                height: '100vh',
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
            }}
        >
            {/* Overlay */}
            <div className="login-overlay"></div>

            {/* Card */}
            <div className="login-card shadow-lg p-4 bg-white rounded position-relative">
                <div className="text-center mb-3">
                    <img src={Logo} alt="logo" style={{ width: 100, height: 100 }} />
                </div>
                <h4 className="text-center mb-4 fw-bold">Sign In</h4>

                {error && (
                    <Alert color="danger" toggle={() => setError(null)}>
                        {error}
                    </Alert>
                )}

                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                        <Label htmlFor="exampleInputEmail1">Email</Label>
                        <Input
                            type="email"
                            className="form-control"
                            id="exampleInputEmail1"
                            aria-describedby="emailHelp"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                            placeholder="you@example.com"
                            autoComplete="username"
                        />
                    </FormGroup>

                    <FormGroup>
                        <Label htmlFor="exampleInputPassword1">Password</Label>
                        <Input
                            type="password"
                            className="form-control"
                            id="exampleInputPassword1"
                            value={password}
                            onChange={e => setPassword(e.target.value)}
                            placeholder="Enter your password"
                            autoComplete="current-password"
                        />
                    </FormGroup>

                    <FormGroup check className="mb-3">
                        <Input
                            type="checkbox"
                            className="form-check-input"
                            id="exampleCheck1"
                            checked={remember}
                            onChange={e => setRemember(e.target.checked)}
                        />{' '}
                        <Label className="form-check-label" htmlFor="exampleCheck1">
                            Remember me
                        </Label>
                    </FormGroup>

                    <Button
                        color="primary"
                        type="submit"
                        className="w-100"
                        disabled={loading}
                    >
                        {loading ? 'Signing in...' : 'Sign in'}
                    </Button>

                    <div className="text-end mt-2">
                        <Button color="link" className="p-0 text-muted">
                            Forgot password?
                        </Button>
                    </div>
                </Form>

                <div className="text-center text-muted small mt-4">
                    Made by VTI | © 2025
                </div>
            </div>
        </div>
    );
};

export default LoginPage;
