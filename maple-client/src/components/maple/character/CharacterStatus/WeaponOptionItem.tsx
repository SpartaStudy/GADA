import styled from "styled-components";
import { MATCH_COLOR } from "../../../../@types/maple/WeaponTypes";

interface Props {
  optionName?: string;
  total?: string | undefined;
  base?: string | undefined;
  exceptional?: string | undefined;
  add?: string | undefined;
  etc?: string | undefined;
  starforce?: string | undefined;
  unit?: string;
  desc?: string | undefined;
  highlight?: "레전드리" | "유니크" | "에픽" | undefined;
}

interface StyledOptionProps {
  $enhanced?: boolean;
  $highlight?: string;
}

interface StyledExtraOptionProps {
  color?: string;
}

const StyledList = styled.li`
  width: 100%;
  font-size: 0.8rem;
  color: #eee;
  display: flex;
  align-items: center;
`;

const StyledOption = styled.span<StyledOptionProps>`
  color: ${(props) => (props.$enhanced ? "#5FECEC" : props.$highlight ? MATCH_COLOR[props.$highlight] : "#fff")};
  display: ${(props) => (props.$highlight ? "block" : "inline")};
  width: ${(props) => (props.$highlight ? "100%" : "auto")};
  font-size: 0.8rem;
`;

const StyledExtraOption = styled.span<StyledExtraOptionProps>`
  color: ${(props) => (props.color ? props.color : "eee")};
`;

const WeaponOptionItem: React.FC<Props> = ({
  optionName,
  total = 0,
  base = 0,
  exceptional = 0,
  add = 0,
  etc = 0,
  starforce = 0,
  unit = "",
  desc,
  highlight,
}) => {
  if ((+total === 0 && desc === undefined) || +total === 255) return null;

  if (desc) {
    return (
      <StyledList>
        <StyledOption $highlight={highlight}>{`${desc}${total ? ` : ${total}${unit}` : ""}`}</StyledOption>
      </StyledList>
    );
  }

  return (
    <StyledList>
      <StyledOption $enhanced={+total > +base}>{`${optionName} : +${total}${unit}`}</StyledOption>
      {!desc && +total > +base && (
        <>
          (<StyledExtraOption>{`${+base}`}</StyledExtraOption>
          {+exceptional > 0 && <StyledExtraOption color="#AAAAFE">{`+${exceptional}`}</StyledExtraOption>}
          {+add > 0 && <StyledExtraOption color="#CAFD02">{`+${add}`}</StyledExtraOption>}
          {+etc > 0 && <StyledExtraOption color="#3F7BC0">{`+${etc}`}</StyledExtraOption>}
          {+starforce > 0 && <StyledExtraOption color="#FDCA00">{`+${starforce}`}</StyledExtraOption>})
        </>
      )}
    </StyledList>
  );
};

export default WeaponOptionItem;

