import React, { useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { accountService } from '../../api/accountService';
import { useAuth } from '../../context/AuthContext';

function LoginPage() {
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
      setError('Please enter both email and password');
      return;
    }
    if (!validateEmail(email)) {
      setError('Please enter a valid email address');
      return;
    }

    try {
      setLoading(true);
      // Use the new accountService.login API which queries by email and validates password when present.
      const matched = await accountService.login(email, password);
      if (!matched) {
        setError('No account found for this email or incorrect password');
        return;
      }

      setMessage(`Welcome back, ${matched.fullName ?? matched.userName ?? matched.email}`);

      // set global auth user so app can show logout and user info
      login(matched);

      // Redirect to the page the user originally tried to access (or /account)
      setTimeout(() => navigate(from), 700);
    } catch (err: any) {
      setError(err?.message || 'Login failed');
    } finally {
      setLoading(false);
    }
  }

  return (
    <div style={{ maxWidth: 520, margin: '24px auto' }}>
      <h2>Login</h2>
      {/* https://getbootstrap.com/docs/4.4/components/forms/ */}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="exampleInputEmail1">Email address</label>
          <input
            type="email"
            className="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
            value={email}
            onChange={e => setEmail(e.target.value)}
            placeholder="you@example.com"
            autoComplete="username"
          />
          <small id="emailHelp" className="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>

        <div className="form-group">
          <label htmlFor="exampleInputPassword1">Password</label>
          <input
            type="password"
            className="form-control"
            id="exampleInputPassword1"
            value={password}
            onChange={e => setPassword(e.target.value)}
            placeholder="Enter your password"
            autoComplete="current-password"
          />
        </div>

        <div className="form-group form-check">
          <input
            type="checkbox"
            className="form-check-input"
            id="exampleCheck1"
            checked={remember}
            onChange={e => setRemember(e.target.checked)}
          />
          <label className="form-check-label" htmlFor="exampleCheck1">Check me out</label>
        </div>

        <button type="submit" className="btn btn-primary" disabled={loading}>
          {loading ? 'Signing in...' : 'Submit'}
        </button>

        {error && <div className="alert alert-danger mt-3">{error}</div>}
        {message && <div className="alert alert-success mt-3">{message} — redirecting...</div>}
      </form>
    </div>
  );
}

export default LoginPage;
