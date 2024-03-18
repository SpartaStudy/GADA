import Link from "next/link";
import React from "react";

const PageButton = () => {
  return (
    <Link
      href="https://maple.gada.app"
      className="w-[160px] h-[40px] bg-third-bg-color rounded-md absolute bottom-[24px] flex justify-center items-center"
    >
      바로가기
    </Link>
  );
};

export default PageButton;

