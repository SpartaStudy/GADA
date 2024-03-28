import Link from "next/link";
import React from "react";

const CharacterListItem = ({
  rank,
  name,
  world,
  level,
}: {
  rank: number;
  name: string;
  world: string;
  level: number;
}) => {
  return (
    <li className="relative m-0 p-0 w-full h-[40px] px-[8px] hover:cursor-pointer hover:bg-third-bg-color">
      <Link href={`https://maple.gada.app/Character/${name}`} className="relative w-full h-full flex items-center">
        <div className="w-[18px] h-[22px] bg-primary-bg-color rounded-sm font-bold flex items-center justify-center">
          {rank}
        </div>
        <div className="ml-[8px]">{name}</div>
        <div className="relative top-[1px] ml-[8px] text-legendary-color text-xs">{world}</div>
        <div className="relative top-[1px] ml-[8px] text-xs">Lv.{level}</div>
      </Link>
    </li>
  );
};

export default CharacterListItem;

