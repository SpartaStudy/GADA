import axios, { AxiosResponse } from "axios";
import { TCharacterRank, TPopularCharacter } from "../@types/character";
import { TCharacterRankResponse, TPopularCharacterResponse } from "../@types/response";

export const fetchPopularCharacter = async (): Promise<TPopularCharacter[] | null> => {
  try {
    // 서버 사이드인데 이렇게 호출하는게 맞나?
    const response = await axios.get<AxiosResponse<TPopularCharacterResponse, any>>(
      `${process.env.REACT_APP_API_URL}/character/getPopularCharacters`
    );

    if (response.data.data) {
      return response.data.data.ranking;
    }

    return null;
  } catch (err) {
    console.error("fetchPopularCharacter failed");
  }

  return null;
};

export const fetchCharacterRank = async (): Promise<TCharacterRank[] | null> => {
  try {
    // 서버 사이드인데 이렇게 호출하는게 맞나?
    const response = await axios.get<AxiosResponse<TCharacterRankResponse, any>>(
      `${process.env.REACT_APP_API_URL}/ranking/combatPowerRanking?page=1`
    );

    if (response.data.data) {
      const rank = response.data.data.content;
      return rank.slice(0, 5);
    }

    return null;
  } catch (err) {
    console.error("fetchPopularCharacter failed");
  }

  return null;
};

