import React from 'react';
import styled from 'styled-components';

const StyledBox = styled.div`
  width: 100%;
  min-height: 40px;
  background-color: #3d444c;
  display: grid;
  grid-template-columns: 0.5fr 2fr 1fr 1fr 1fr 1fr 1fr;
`;

const TextBox = styled.div`
  color: white;
  display:flex;
  justify-content: center;
  align-items: center;
`

const CombatPowerTableHeader = () => {
  return (
    <StyledBox>
      <TextBox>순위</TextBox>
      <TextBox>캐릭터</TextBox>
      <TextBox>레벨</TextBox>
      <TextBox>전투력</TextBox>
      <TextBox>직업</TextBox>
      <TextBox>길드</TextBox>
      <TextBox>월드</TextBox>
    </StyledBox>
  );
};

export default CombatPowerTableHeader;