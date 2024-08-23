import React, { useEffect, useRef, useState } from "react";
import Info from "./info";
import Calculator from "./Calculator";

const Classes = () => {
  const [selectedType, setSelectedType] = useState("Yoga");
  const yogaButtonRef = useRef(null);

  useEffect(() => {
    // Sayfa yüklendiğinde yogaButton elemanına odaklan
    if (yogaButtonRef.current) {
      yogaButtonRef.current.focus();
      window.scrollTo(0, 0);
    }
  }, []);

  return (
    <div className="classes">
      <div className="top-classes">
        <div className="main">
          <h2>OUR CLASSES</h2>
          <p>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Delectus
            illo provident architecto non quam, doloribus consectetur eum beatae
            sit aperiam.
          </p>
        </div>

        <div className="button-classes">
          <div className="top-button">
            <button
              className="btn-class"
              id="btn-yoga"
              ref={yogaButtonRef}
              onClick={() => setSelectedType("Yoga")}
            >
              Yoga
            </button>
            <button
              className="btn-class"
              id="btn-group"
              onClick={() => setSelectedType("Group")}
            >
              Group
            </button>
          </div>
          <div className="bottom-button">
            <button
              className="btn-class"
              id="btn-solo"
              onClick={() => setSelectedType("Solo")}
            >
              Solo
            </button>
            <button
              className="btn-class"
              id="btn-streching"
              onClick={() => setSelectedType("Streching")}
            >
              Streching
            </button>
          </div>
        </div>
        <Info selectedType={selectedType} />
      </div>
      <Calculator />
    </div>
  );
};

export default Classes;
