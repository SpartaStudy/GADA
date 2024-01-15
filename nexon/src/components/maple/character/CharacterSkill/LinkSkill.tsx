import React, { useEffect } from 'react';
import SkillBox from './SkillBox';
import { skillType } from './CharacterSkill';
import SkillSquare from './SkillSquare';

interface Props {
    skillList: skillType[];
}


const LinkSkill: React.FC<Props> = ({ skillList }) => {
    useEffect(() => {
        console.log(skillList);
        console.log(skillList[0].skill_icon);
        
    },[])
    return (
        <SkillBox>
            {skillList.map((_, index) => (
                <SkillSquare skillImg={skillList[index].skill_icon}
                    skillLevel={skillList[index].skill_level} />
            ))}
        </SkillBox>
    )
}

export default LinkSkill;