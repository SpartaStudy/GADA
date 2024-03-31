import { convertCombatPower } from "@/app/hook/commonUtils";
import Link from "next/link";
import React from "react";

const CharacterListItem = ({
  rank,
  name,
  world,
  level,
  combat_power,
}: {
  rank: number;
  name: string;
  world: string;
  level: number;
  combat_power: number;
}) => {
  const convertedPower = convertCombatPower(combat_power);

  return (
    <li className="relative m-0 p-0 w-full h-[40px] px-[8px] hover:cursor-pointer hover:bg-third-bg-color">
      <Link href={`https://maple.gada.app/Character/${name}`} className="relative w-full h-full flex items-center">
        <div className="w-[18px] h-[22px] bg-primary-bg-color rounded-sm font-bold flex items-center justify-center">
          {rank}
        </div>
        <div className="ml-[8px]">{name}</div>
        <div className="relative top-[1px] ml-[8px] text-legendary-color text-xs">{world}</div>
        <div className="relative top-[1px] ml-[8px] text-xs">Lv.{level}</div>
        <div className="absolute top-[30%] right-[8px] text-xs text-slate-400">{convertedPower}</div>
      </Link>
    </li>
  );
};

export default CharacterListItem;

