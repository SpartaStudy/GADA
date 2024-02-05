import React from "react";
import SkillBox from "./SkillBox";
import SkillSquare from "./SkillSquare";
import { skillType } from "../../../../@types/maple/CharacterSkillType";
import styled from "styled-components";
import SolErda from "./SolErda";
import NoSkill from "./NoSkill";
import DashedLine from "../../../common/DashedLine";

interface Props {
  skillList: skillType[];
  solErdaEnergy: number;
  solErdaFragment: number;
  haveSixSkill: boolean;
}

export const SkillContainer = styled.div`
  display: flex;
  flex-direction: column;
  border-radius: 8px;
  margin: 16px 0px 16px 0px;
  background-color: var(--secondary-bg-color);
  box-shadow: var(--custom-shadow);
`;

export const SkillDegree = styled.div`
  padding: 8px 0px 8px 20px;
  font-weight: 800;
`;

const SixSkill: React.FC<Props> = ({ skillList, solErdaEnergy, solErdaFragment, haveSixSkill }) => {
  return (
    <SkillContainer>
      <SkillDegree>6차 스킬</SkillDegree>
      <DashedLine />
      {haveSixSkill ? (
        <>
          <SkillBox>
            {skillList?.map((_, index) => (
              <SkillSquare key={index} skill={skillList[index]} />
            ))}
          </SkillBox>
          <DashedLine />
          <SolErda solErdaEnergy={solErdaEnergy} solErdaFragment={solErdaFragment} />
        </>
      ) : (
        <NoSkill />
      )}
    </SkillContainer>
  );
};

export default SixSkill;
