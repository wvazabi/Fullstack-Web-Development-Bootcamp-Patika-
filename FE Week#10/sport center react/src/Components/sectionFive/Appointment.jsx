import React, { useState } from "react";

const Appointment = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
  };

  return (
    <div className="appointment">
      <div className="contact-info">
        <div className="phone-info">
          <h3>Mobile Number</h3>
          <p>+1 234 567 890</p>
        </div>
        <div className="email-info">
          <h3>Email Address</h3>
          <p>demo@demo.com</p>
        </div>
      </div>

      <form className="form" onSubmit={handleSubmit}>
        <h3>Make An Appointment</h3>
        <input
          type="text"
          id="yourName"
          name="yourName"
          placeholder="Enter your name"
          required
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="email"
          id="yourEmail"
          name="yourEmail"
          placeholder="Enter your email"
          required
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <textarea
          id="message"
          name="message"
          placeholder="Enter your message"
          rows="4"
          required
          value={message}
          onChange={(e) => setMessage(e.target.value)}
        ></textarea>
        <button
          type="submit"
          onClick={() => {
            setName("");
            setEmail("");
            setMessage("");
          }}
        >
          Send
        </button>
      </form>
    </div>
  );
};

export default Appointment;
