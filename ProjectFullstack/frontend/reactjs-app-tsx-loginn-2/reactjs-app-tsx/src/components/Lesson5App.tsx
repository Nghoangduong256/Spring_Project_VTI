import React, { useState } from "react";
import "../App.css";

/* ------------------------------------------------
   1️⃣ Composition (with props)
   - Parent passes data (props) down to children
--------------------------------------------------- */
function UserCard({ name, role }: { name: string; role: string }) {
  return (
    <div className="card">
      <h3>Composition Example</h3>
      <p>Name: {name}</p>
      <p>Role: {role}</p>
    </div>
  );
}

function CompositionExample() {
  return <UserCard name="Trung" role="Frontend Developer" />;
}

/* ------------------------------------------------
   2️⃣ Lifting State Up (using props)
   - Shared state managed in parent, passed down as props
--------------------------------------------------- */
function InputBox({
  value,
  onChange,
}: {
  value: string;
  onChange: (v: string) => void;
}) {
  return (
    <input
      value={value}
      onChange={(e) => onChange(e.target.value)}
      placeholder="Type something..."
    />
  );
}

function DisplayBox({ value }: { value: string }) {
  return <p>Typed Text: {value}</p>;
}

function LiftingStateUpExample() {
  const [text, setText] = useState("");

  // Demo useEffect to show state updates in console
  // demo useEffect instead of licycling console.log in render

  React.useEffect(() => {
    // console.log("Text state updated:", text);
  }, [text]);
  
  
  return (
    <div className="example">
      <h3>Lifting State Up Example</h3>
      {/* pass props to both children */}
      <InputBox value={text} onChange={setText} />
      <DisplayBox value={text} />
    </div>
  );
}

/* ------------------------------------------------
   3️⃣ Context-like pattern (using props)
   - Simulate Context by passing props deeply
   - “Prop Drilling” version of Context
--------------------------------------------------- */
function ThemeButton({
  theme,
  toggleTheme,
}: {
  theme: string;
  toggleTheme: () => void;
}) {
  return (
    <button onClick={toggleTheme}>
      Current Theme: {theme.toUpperCase()}
    </button>
  );
}

// Intermediate component that passes props down further
function Toolbar({
  theme,
  toggleTheme,
}: {
  theme: string;
  toggleTheme: () => void;
}) {
  return (
    <div className="toolbar">
      <ThemeButton theme={theme} toggleTheme={toggleTheme} />
    </div>
  );
}

function ContextWithPropsExample() {
  const [theme, setTheme] = useState("light");
  const toggleTheme = () => setTheme((t) => (t === "light" ? "dark" : "light"));

  return (
    <div className={`example theme-${theme}`}>
      <h3>Context (Prop Drilling) Example</h3>
      {/* pass theme + toggle function as props */}
      <Toolbar theme={theme} toggleTheme={toggleTheme} />
    </div>
  );
}

/* ------------------------------------------------
   🧩 Main App Component
--------------------------------------------------- */
function Lesson5App() {
  return (
    <div className="App">
      <h1>Share Data Between Components Using Props</h1>
      <CompositionExample />
      <LiftingStateUpExample />
      <ContextWithPropsExample />
    </div>
  );
}

export default Lesson5App;
