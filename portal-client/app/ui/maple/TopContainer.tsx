import React from "react";
import CharacterImage from "./CharacterImage";
import PageButton from "./PageButton";

const TopContainer = () => {
  return (
    <div className="w-full h-3/5 relative flex justify-center pt-[40px] box-border">
      <CharacterImage />
      <PageButton />
    </div>
  );
};

export default TopContainer;

