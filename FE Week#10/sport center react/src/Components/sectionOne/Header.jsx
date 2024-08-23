import Navbar from "./Navbar.jsx";
import Cards from "./Cards.jsx";

const Header = () => {
  return (
    <div className="header-section">
      <div className="header home" id="home">
        <div className="top-header">
          <Navbar />
          <div className="menu-bg" id="menu-bg"></div>
          <div className="content">
            <a className="top-content">Powerful</a>
            <h1>Group Practice With Trainer</h1>
            <p>
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Dolores
              quam nesciunt doloribus veniam corporis! Omnis vitae debitis
              praesentium vero, saepe ullam quod illo blanditiis quo,
              exercitationem libero velit quasi cupiditate.
            </p>
            <div className="buttons">
              <button className="st-button">Sign Up</button>
              <button className="nd-button">Details</button>
            </div>
          </div>
        </div>

        <Cards />
      </div>
    </div>
  );
};

export default Header;
