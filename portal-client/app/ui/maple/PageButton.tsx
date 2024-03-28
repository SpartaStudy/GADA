import Link from "next/link";
import React from "react";

const PageButton = () => {
  return (
    <Link
      href="https://maple.gada.app"
      className="w-[200px] h-[40px] bg-main-button-color rounded-md absolute bottom-[64px] flex justify-center items-center shadow-lg hover:bg-main-button-focus-color"
    >
      <span className="text-md font-bold tracking-widest">사이트 이동하기</span>
    </Link>
  );
};

export default PageButton;

