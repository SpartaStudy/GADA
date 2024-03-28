import axios, { AxiosResponse } from "axios";
import { TPopularCharacter } from "../@types/character";
import { TPopularCharacterResponse } from "../@types/response";

export const fetchPopularCharacter = async (): Promise<TPopularCharacter[] | null> => {
  try {
    // 서버 사이드인데 이렇게 호출하는게 맞나?
    const response = await axios.get<AxiosResponse<TPopularCharacterResponse, any>>(
      `${process.env.REACT_APP_API_URL}/character/getPopularCharacters`
    );
    // const data: TResponse = response.data;

    if (response.data.data) {
      return response.data.data.ranking;
    }

    return null;
  } catch (err) {
    console.error("fetchPopularCharacter failed");
  }

  return null;
};

