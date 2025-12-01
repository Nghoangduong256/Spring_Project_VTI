import React from 'react';

function UserCard({ name, role }: { name: string; role: string }) {
  return (
    <div className="card">
      <h3>Composition Example</h3>
      <p>Name: {name}</p>
      <p>Role: {role}</p>
    </div>
  );
}

export default UserCard;
