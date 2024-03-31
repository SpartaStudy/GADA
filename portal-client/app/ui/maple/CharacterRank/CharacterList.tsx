import React from "react";
import CharacterListItem from "./CharacterListItem";
import { TCharacterRank } from "@/app/@types/character";

const CharacterList = ({ characters }: { characters: TCharacterRank[] }) => {
  return (
    <ul className="m-0 p-0 w-full">
      {characters.map((character) => (
        <CharacterListItem
          key={character.rank}
          rank={character.rank}
          name={character.character_name}
          world={character.world_name}
          level={character.character_level}
          combat_power={character.combat_power}
        />
      ))}
    </ul>
  );
};

export default CharacterList;

