import React, { useRef } from 'react';

// This is nonfunctional. Need to set up server-side endpoint to receive data.

function ContactForm() {
  const formRef = useRef(null);

  const handleSubmit = (event) => {
    event.preventDefault();
    // Add form submission logic here
    console.log('Form submitted!');

    // Clear the form
    formRef.current.reset();
  };

  const handleButtonClick = () => {
    // Add button click logic here
    console.log('Button clicked!');
  };

  const formStyle = {
    maxWidth: '500px',
    margin: 'auto',
  };

  const labelStyle = {
    color: 'black',
  };

  return (
    <form ref={formRef} id="contact-form" onSubmit={handleSubmit} method="POST" style={formStyle}>
      <div className="mb-3">
        <label htmlFor="name" className="form-label" style={labelStyle}>Name</label>
        <input type="text" className="form-control" id="name" />
      </div>
      <div className="mb-3">
        <label htmlFor="email" className="form-label" style={labelStyle}>Email address</label>
        <input type="email" className="form-control" id="email" aria-describedby="emailHelp" />
      </div>
      <div className="mb-3">
        <label htmlFor="message" className="form-label" style={labelStyle}>Message</label>
        <textarea className="form-control" id="message" rows="5"></textarea>
      </div>
      <button type="submit" className="btn btn-primary" onClick={handleButtonClick}>Submit</button>
    </form>
  );
}

export default ContactForm;
