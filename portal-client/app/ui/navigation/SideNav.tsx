import React from "react";
import NavLinks from "./NavLinks";

export type TLink = {
  name: string;
  href: string;
  icon: string;
  alt: string;
};

const links: TLink[] = [
  { name: "maplestory", href: "/", icon: "maple_logo.webp", alt: "maple logo" },
  { name: "dungeon&fighter", href: "/dungeon", icon: "dnf_logo.webp", alt: "dungeon logo" },
];

const SideNav = () => {
  return (
    <div className="w-[80px] bg-secondary-bg-color h-full flex flex-col p-[8px]">
      <NavLinks links={links} />
    </div>
  );
};

export default SideNav;

