import { useCallback } from "react";
import { useRecoilState } from "recoil";
import {
  atomCharacterUnion,
  atomCharacterUnionArtifact,
  atomUnionGrid,
} from "../../atoms/maple/characterUnionState";
import {
  getCharacterUnion,
  getCharacterUnionArtifact,
} from "../../api/Character/Union";
import { UnionBlockType } from "../../@types/maple/CharacterUnionTypes";

const useCharacterUnion = () => {
  const [characterUnion, setcharacterUnion] =
    useRecoilState(atomCharacterUnion);
  const [unionGrid, setUnionGrid] = useRecoilState(atomUnionGrid);
  const [unionArtifact, setUnionArtifact] = useRecoilState(
    atomCharacterUnionArtifact
  );

  const getUnion = useCallback(
    (characterName: string) => {
      getCharacterUnion(characterName)
        .then(({ data, status }) => {
          if (status === 200) {
            setcharacterUnion(data);
            setUnionGrid((_) => {
              const grid = Array.from<Array<Array<boolean>>, Array<boolean>>(
                { length: 20 },
                () => Array.from({ length: 22 }, () => false)
              );
              data.data.union_block.forEach((v: UnionBlockType) => {
                v.block_position?.forEach((v) => {
                  if (
                    0 <= 10 - v.y &&
                    20 > 10 - v.y &&
                    0 <= v.x + 11 &&
                    22 > v.x + 11
                  ) {
                    grid[10 - v.y][v.x + 11] = true;
                  }
                });
              });
              return grid;
            });
          }
        })
        .catch((res) => {
          if (res.response.status === 500) {
            // console.log("Error getCharacterUnion");
          }
        });
    },
    [setcharacterUnion, setUnionGrid]
  );

  const getUnionArtifact = useCallback(
    (characterName: string) => {
      getCharacterUnionArtifact(characterName)
        .then(({ data, status }) => {
          if (status === 200) {
            setUnionArtifact(data);
          }
        })
        .catch((res) => {
          if (res.response.status === 500) {
            // console.log("Error getUnionArtifact");
          }
        });
    },
    [setUnionArtifact]
  );

  return {
    characterUnion,
    setcharacterUnion,
    unionGrid,
    setUnionGrid,
    getUnion,
    unionArtifact,
    setUnionArtifact,
    getUnionArtifact,
  };
};

export default useCharacterUnion;
