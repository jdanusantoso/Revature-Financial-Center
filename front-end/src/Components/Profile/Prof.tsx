import React from "react";

const prof = (props: any) => {
  return (
    <div className="profile">
      <h3>{props.username}</h3>
      <h3>{props.password}</h3>
    </div>
  );
};

export default prof;
