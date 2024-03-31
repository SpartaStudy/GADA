import React from "react";
import ListHeader from "./ListHeader";
import CharacterList from "./CharacterList";
import { fetchCharacterRank } from "@/app/api/maple_data";
import { TCharacterRank } from "@/app/@types/character";

const CharacterRank = async () => {
  const _characters: TCharacterRank[] | null = await fetchCharacterRank();

  if (!_characters) return null;

  return (
    <div className="m-0 p-0 w-[360px] h-[236px] mx-[16px] bg-secondary-bg-color rounded-[4px]">
      <ListHeader />
      <CharacterList characters={_characters} />
    </div>
  );
};

export default CharacterRank;

