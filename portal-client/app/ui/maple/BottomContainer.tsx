import React from "react";
import FamousCharacter from "./FamousCharacter";

const BottomContainer = () => {
  return (
    <div className="w-full h-2/5 relative flex justify-center box-border">
      <FamousCharacter />
      <FamousCharacter />
    </div>
  );
};

export default BottomContainer;

