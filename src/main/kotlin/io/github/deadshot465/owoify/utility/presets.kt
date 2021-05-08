package io.github.deadshot465.owoify.utility

import io.github.deadshot465.owoify.structures.Word

val SPECIFIC_WORD_MAPPING_LIST = listOf<(Word) -> Word>(
    ::mapFucToFwuc,
    ::mapMomToMwom,
    ::mapTimeToTim,
    ::mapMeToMwe,
    ::mapNVowelToNy,
    ::mapOverToOwor,
    ::mapOveToUv,
    ::mapHahaToHeheXd,
    ::mapTheToTeh,
    ::mapYouToU,
    ::mapReadToWead,
    ::mapWorseToWose
)

val UVU_MAPPING_LIST = listOf<(Word) -> Word>(
    ::mapOToOwO,
    ::mapEwToUwu,
    ::mapHeyToHay,
    ::mapDeadToDed,
    ::mapNVowelTToNd
)

val UWU_MAPPING_LIST = listOf<(Word) -> Word>(
    ::mapBracketToStarTrails,
    ::mapPeriodCommaExclamationSemicolonToKaomojis,
    ::mapThatToDat,
    ::mapThToF,
    ::mapLeToWal,
    ::mapVeToWe,
    ::mapRyToWwy,
    ::mapROrLToW
)

val OWO_MAPPING_LIST = listOf<(Word) -> Word>(
    ::mapLlToWw,
    ::mapVowelOrRExceptOLToWl,
    ::mapOldToOwld,
    ::mapOlToOwl,
    ::mapLOrROToWo,
    ::mapSpecificConsonantsOToLetterAndWo,
    ::mapVOrWLeToWal,
    ::mapFiToFwi,
    ::mapVerToWer,
    ::mapPoiToPwoi,
    ::mapSpecificConsonantsLeToLetterAndWal,
    ::mapConsonantsRToConsonantW,
    ::mapLyToWy,
    ::mapPleToPwe,
    ::mapNrToNw
)