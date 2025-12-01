import React from 'react';

function DemoList() {
  const items = ['Coffee', 'Tea', 'Milk'];
  return (
    <div style={{marginTop: 24}}>
      <h2>An Ordered HTML List</h2>
      <ol>
        {items.map((item, idx) => (
          <li key={idx}>{item}</li>
        ))}
      </ol>
    </div>
  );
}

export default DemoList;
