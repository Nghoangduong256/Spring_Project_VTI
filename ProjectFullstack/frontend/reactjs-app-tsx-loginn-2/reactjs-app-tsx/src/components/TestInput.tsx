import React, { useState } from 'react';

function TestInput() {
  const [value, setValue] = useState('');

  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    console.log('Input changed:', event, event.target.value);
    setValue(event.target.value);
  }
  function handleClear() {
    setValue('');
  }

  // ToDo initial value from props, input props interface


  return (
    <div>
      <input
        type="text"
        value={value}
        onChange={handleChange}
        placeholder="Type something..."
      />
      <p>Hello: {value}</p>
      <button onClick={handleClear}>Clear</button>
    </div>
  );
}

export default TestInput;
