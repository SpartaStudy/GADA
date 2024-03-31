import React, { Suspense } from "react";
import FamousCharacter from "./FamousCharacter/FamousCharacter";
import { SkeletonCharacterRank, SkeletonFamousCharacter } from "../skeletons";
import CharacterRank from "./CharacterRank/CharacterRank";

const BottomContainer = () => {
  return (
    <div className="w-full h-2/5 relative flex justify-center box-border">
      <Suspense fallback={<SkeletonFamousCharacter />}>
        <FamousCharacter />
      </Suspense>
      <Suspense fallback={<SkeletonCharacterRank />}>
        <CharacterRank />
      </Suspense>
    </div>
  );
};

export default BottomContainer;

