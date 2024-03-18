import Image from "next/image";
import Link from "next/link";
import React from "react";

interface Props {
  links: { name: string; href: string; icon: string; alt: string }[];
}

const NavLinks = ({ links }: Props) => {
  return (
    <div className="w-full flex flex-col items-center content-center gap-[16px] py-[16px]">
      {links.map((link) => (
        <Link key={link.name} href={link.href} className="flex w-[48px] h-[48px] overflow-hidden">
          <Image src={`/images/${link.icon}`} alt={link.alt} width={40} height={40} className="object-contain" />
        </Link>
      ))}
    </div>
  );
};

export default NavLinks;

