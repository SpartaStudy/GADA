import React, { useEffect } from "react";
import styled from "styled-components";
import GuildWaterwayTable from "./GuildWaterwayTable";
import RankTablePageMove from "../RankTablePageMove";
import useRanking from "../../../../hooks/maple/useRanking";

const StyledBox = styled.div`
  width: 100%;
  margin-top: 5px;
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-bottom: 10px;
  min-height: 1000px;
`;

const GuildWaterway = () => {
  const { setTotalPage } = useRanking();
  useEffect(() => setTotalPage(9999), [setTotalPage]);
  return (
    <StyledBox>
      <GuildWaterwayTable />
      <RankTablePageMove />
    </StyledBox>
  );
};

export default GuildWaterway;
