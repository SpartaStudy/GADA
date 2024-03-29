import React from "react";
import styled from "styled-components";

interface Props {
  serverName: string;
  characterName: string;
  jobGrowName: string;
  level: number;
}

const StyledBox = styled.div`
  position: absolute;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  bottom: 0px;
  width: 100%;
  font-size: 0.9rem;
`;

const ServerText = styled.div`
  color: #87e49c;
`;

const NicknameText = styled.div``;

const SearchCharacterText: React.FC<Props> = ({
  serverName,
  characterName,
  jobGrowName,
  level,
}) => {
  return (
    <StyledBox>
      <ServerText>{serverName}</ServerText>
      <NicknameText>{`Lv. ${level} ${characterName}`}</NicknameText>
      <NicknameText>{`[${jobGrowName}]`}</NicknameText>
    </StyledBox>
  );
};

export default SearchCharacterText;
