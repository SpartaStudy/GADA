import { TCharacterRank, TPopularCharacter } from "./character";

export type TResponse = {
  timestamp: string;
  data: any;
};

export type TPopularCharacterResponse = {
  ranking: TPopularCharacter[];
};

export type TCharacterRankResponse = {
  content: TCharacterRank[];
};

