import React from "react";
import client1 from "../../assets/client1.jpg";
import client2 from "../../assets/client2.jpg";

const Comments = () => {
  return (
    <div class="client">
      <div class="client-main ">
        <div class="st-client">
          <img src={client1} alt="Client 1" />
          <div class="client-info">
            <h4>Diet Expert</h4>
            <p>CFO</p>
          </div>
        </div>

        <div class="comment">
          <p>
            Lorem, ipsum dolor sit amet consectetur adipisicing elit. A sit
            atque deserunt delectus nesciunt reiciendis animi beatae, rem dicta
            suscipit quas nam voluptatem itaque quasi recusandae necessitatibus
            tempore fugit quod!
          </p>
        </div>
      </div>
      <div class="client-main">
        <div class="nd-client">
          <img src={client2} alt="Client 2" />
          <div class="client-info">
            <h4>Cardio Trainer</h4>
            <p>CEO</p>
          </div>
        </div>
        <div class="comment">
          <p>
            Lorem, ipsum dolor sit amet consectetur adipisicing elit. A sit
            atque deserunt delectus nesciunt reiciendis animi beatae, rem dicta
            suscipit quas nam voluptatem itaque quasi recusandae necessitatibus
            tempore fugit quod!
          </p>
        </div>
      </div>
    </div>
  );
};

export default Comments;
