"use client";

import React from "react";
import CurrentLink from "./CurrentLink";
import NavLinks from "./NavLinks";
import { usePathname } from "next/navigation";

type Link = {
  name: string;
  href: string;
  icon: string;
  alt: string;
};

const links: Link[] = [
  { name: "maplestory", href: "/", icon: "maple_logo.png", alt: "maple logo" },
  { name: "dungeon&fighter", href: "/dungeon", icon: "dungeon_icon.png", alt: "dungeon logo" },
];

const SideNav = () => {
  const pathname = usePathname();
  const currIcon: Link[] = links.filter((link) => link.href === pathname);
  console.log(pathname, currIcon);

  return (
    <div className="w-[80px] bg-secondary-bg-color h-full flex flex-col p-[8px]">
      <CurrentLink icon={currIcon[0]?.icon} alt={currIcon[0]?.alt} />
      <NavLinks links={links} />
    </div>
  );
};

export default SideNav;

