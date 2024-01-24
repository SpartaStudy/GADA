import styled from "styled-components";
import PetList from "./PetList";

const StyledBox = styled.div`
  width: 320px;
  background-color: #3d454d;
  margin-top: 8px;
  border-radius: 4px;
  padding: 16px;
  box-sizing: border-box;
`;

const StyledTitle = styled.h3`
  margin: 0;
  margin-bottom: 8px;
  padding: 0;
  font-size: 1.1rem;
  font-weight: 700;
  color: #fff;
`;

const PetWeapons = () => {
  return (
    <StyledBox>
      <StyledTitle>펫 장비</StyledTitle>
      <PetList />
    </StyledBox>
  );
};

export default PetWeapons;
