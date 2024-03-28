"use client";

import Image from "next/image";
import Link from "next/link";
import { usePathname } from "next/navigation";
import React from "react";
import { TLink } from "./SideNav";
import clsx from "clsx";

interface Props {
  links: { name: string; href: string; icon: string; alt: string }[];
}

const NavLinks = ({ links }: Props) => {
  const pathname = usePathname();
  const currIcon: TLink[] = links.filter((link) => link.href === pathname);

  return (
    <div className="w-full flex flex-col items-center content-center gap-[16px] py-[16px]">
      {links.map((link) => (
        <Link key={link.name} href={link.href} className={`flex w-[64px] h-[64px] overflow-hidden relative`}>
          <Image className="object-contain" src={`/images/${link.icon}`} alt={link.alt} width={64} height={64} />
          <div
            className={clsx("absolute bottom-0 w-full h-[2px] bg-slate-400 animate-spread-horz", {
              hidden: currIcon[0].name !== link.name,
            })}
          />
        </Link>
      ))}
    </div>
  );
};

export default NavLinks;

