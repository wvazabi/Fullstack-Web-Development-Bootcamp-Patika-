import React, { useEffect, useState } from "react";
import logo from "../../assets/logo.png";

const Navbar = () => {
  const [scrolled, setScrolled] = useState(false);

  useEffect(() => {
    const handleScroll = () => {
      if (window.scrollY === 0) {
        setScrolled(false);
      } else {
        setScrolled(true);
      }
    };

    window.addEventListener("scroll", handleScroll);

    return () => {
      window.removeEventListener("scroll", handleScroll);
    };
  }, []);

  return (
    <div>
      <nav className={`navbar ${scrolled ? "scrolled" : ""}`} id="menu">
        <div>
          <a href="#">
            <img src={logo} alt="Logo" />
          </a>
        </div>
        <input type="checkbox" className="menu-btn" id="menu-btn" />
        <label htmlFor="menu-btn" className="menu-icon">
          <i className="fa-solid fa-bars menu-hmbgr"></i>
        </label>
        <div className="menu">
          <ul className="nav-menu">
            <li>
              <a href="#home">Home</a>
            </li>
            <li>
              <a href="#classes">Classes</a>
            </li>
            <li>
              <a href="#trainer">Trainer</a>
            </li>
            <li>
              <a href="#review">Review</a>
            </li>
            <li>
              <a href="#contact">Contact</a>
            </li>
            <li>
              <a href="#">Join Us</a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  );
};

export default Navbar;
