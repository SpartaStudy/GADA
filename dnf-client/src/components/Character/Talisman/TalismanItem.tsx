import React from "react";
import { useSetRecoilState } from "recoil";
import styled from "styled-components";
import {
  ITEM_TYPE_COLOR,
  TCharacterTalisman,
} from "../../../@types/CharacterTypes";
import useTalismanLocation from "../../../hooks/useItemImageLocation";
import { atomtalismanInfo } from "../../../atoms/ItemInfoState";

interface Props {
  value: TCharacterTalisman;
  idx: number;
}

interface StyledProps {
  $top: number;
  $left: number;
  $rarityColor: string;
}

const StyledBox = styled.div``;
const TalismanImg = styled.img<StyledProps>`
  position: absolute;
  transform: scale(1.2);
  cursor: pointer;
  border: 2px double ${(props) => props.$rarityColor};
  border-radius: 1px;
  margin-top: ${(props) => `${props.$top}%`};
  margin-left: ${(props) => props.$left}%;
`;

const TalismanItem: React.FC<Props> = ({ value, idx }) => {
  const { TalismanLocation } = useTalismanLocation();
  const setTalismanInfo = useSetRecoilState(atomtalismanInfo);
  const [x, y] = TalismanLocation(idx);
  const rarityColor = ITEM_TYPE_COLOR[value.detail!.itemRarity!];
  return (
    <StyledBox>
      <TalismanImg
        src={value.itemImage!}
        alt={"talisman Image"}
        $top={x}
        $left={y}
        $rarityColor={rarityColor}
        onClick={() => {
          setTalismanInfo(value);
        }}
      ></TalismanImg>
    </StyledBox>
  );
};

export default TalismanItem;