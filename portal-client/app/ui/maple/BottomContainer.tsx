import React, { Suspense } from "react";
import FamousCharacter from "./FamousCharacter/FamousCharacter";
import { SkeletonFamousCharacter } from "../skeletons";

const BottomContainer = () => {
  return (
    <div className="w-full h-2/5 relative flex justify-center box-border">
      <Suspense fallback={<SkeletonFamousCharacter />}>
        <FamousCharacter />
      </Suspense>
    </div>
  );
};

export default BottomContainer;

