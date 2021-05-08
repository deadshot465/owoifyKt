package io.github.deadshot465.owoify.utility

import io.github.deadshot465.owoify.structures.Word
import kotlin.random.Random

val O_TO_OWO = Regex("o")
val EW_TO_UWU = Regex("ew")
val HEY_TO_HAY = Regex("([Hh])ey")
val DEAD_TO_DED_UPPER = Regex("Dead")
val DEAD_TO_DED_LOWER = Regex("dead")
val N_VOWEL_T_TO_ND = Regex("n[aeiou]*t")
val READ_TO_WEAD_UPPER = Regex("Read")
val READ_TO_WEAD_LOWER = Regex("read")
val BRACKETS_TO_STARTRAILS_FORE = Regex("[({<]")
val BRACKETS_TO_STARTRAILS_REAR = Regex("[)}>]")
val PERIOD_COMMA_EXCLAMATION_SEMICOLON_TO_KAOMOJIS_FIRST = Regex("[.,](?![0-9])")
val PERIOD_COMMA_EXCLAMATION_SEMICOLON_TO_KAOMOJIS_SECOND = Regex("[!;]+")
val THAT_TO_DAT_UPPER = Regex("That")
val THAT_TO_DAT_LOWER = Regex("that")
val TH_TO_F_UPPER = Regex("TH(?!E)")
val TH_TO_F_LOWER = Regex("[Tt]h(?![Ee])")
val LE_TO_WAL = Regex("le$")
val VE_TO_WE_UPPER = Regex("Ve")
val VE_TO_WE_LOWER = Regex("ve")
val RY_TO_WWY = Regex("ry")
val RORL_TO_W_UPPER = Regex("(?:R|L)")
val RORL_TO_W_LOWER = Regex("(?:r|l)")
val LL_TO_WW = Regex("ll")
val VOWEL_OR_R_EXCEPT_O_L_TO_WL_UPPER = Regex("[AEIUR]([lL])$")
val VOWEL_OR_R_EXCEPT_O_L_TO_WL_LOWER = Regex("[aeiur]l$")
val OLD_TO_OWLD_UPPER = Regex("OLD")
val OLD_TO_OWLD_LOWER = Regex("([Oo])ld")
val OL_TO_OWL_UPPER = Regex("OL")
val OL_TO_OWL_LOWER = Regex("([Oo])l")
val LORR_O_TO_WO_UPPER = Regex("[LR]([oO])")
val LORR_O_TO_WO_LOWER = Regex("[lr]o")
val SPECIFIC_CONSONANTS_O_TO_LETTER_AND_WO_UPPER = Regex("([BCDFGHJKMNPQSTXYZ])([oO])")
val SPECIFIC_CONSONANTS_O_TO_LETTER_AND_WO_LOWER = Regex("([bcdfghjkmnpqstxyz])o")
val VORW_LE_TO_WAL = Regex("[vw]le")
val FI_TO_FWI_UPPER = Regex("FI")
val FI_TO_FWI_LOWER = Regex("([Ff])i")
val VER_TO_WER = Regex("([Vv])er")
val POI_TO_PWOI = Regex("([Pp])oi")
val SPECIFIC_CONSONANTS_LE_TO_LETTER_AND_WAL = Regex("([DdFfGgHhJjPpQqRrSsTtXxYyZz])le$")
val CONSONANT_R_TO_CONSONANT_W = Regex("([BbCcDdFfGgKkPpQqSsTtWwXxZz])r")
val LY_TO_WY_UPPER = Regex("Ly")
val LY_TO_WY_LOWER = Regex("ly")
val PLE_TO_PWE = Regex("([Pp])le")
val NR_TO_NW_UPPER = Regex("NR")
val NR_TO_NW_LOWER = Regex("nr")
val FUC_TO_FWUC = Regex("([Ff])uc")
val MOM_TO_MWOM = Regex("([Mm])om")
val ME_TO_MWE = Regex("([Mm])e")
val N_VOWEL_TO_NY_FIRST = Regex("n([aeiou])")
val N_VOWEL_TO_NY_SECOND = Regex("N([aeiou])")
val N_VOWEL_TO_NY_THIRD = Regex("N([AEIOU])")
val OVE_TO_UV_UPPER = Regex("OVE")
val OVE_TO_UV_LOWER = Regex("ove")
val HAHA_TO_HEHE_XD = Regex("\\b(ha|hah|heh|hehe)+\\b")
val THE_TO_TEH = Regex("\\b([Tt])he\\b")
val YOU_TO_U_UPPER = Regex("\\bYou\\b")
val YOU_TO_U_LOWER = Regex("\\byou\\b")
val TIME_TO_TIM = Regex("\\b([Tt])ime\\b")
val OVER_TO_OWOR = Regex("([Oo])ver")
val WORSE_TO_WOSE = Regex("([Ww])orse")

val FACES = arrayOf("(・`ω´・)", ";;w;;", "owo", "UwU", ">w<", "^w^", "(* ^ ω ^)", "(⌒ω⌒)", "ヽ(*・ω・)ﾉ", "(o´∀`o)", "(o･ω･o)", "＼(＾▽＾)／", "(*^ω^)", "(◕‿◕✿)", "(◕ᴥ◕)", "ʕ•ᴥ•ʔ", "ʕ￫ᴥ￩ʔ", "(*^.^*)", "(｡♥‿♥｡)", "OwO", "uwu", "uvu", "UvU", "(*￣з￣)", "(つ✧ω✧)つ", "(/ =ω=)/", "(╯°□°）╯︵ ┻━┻", "┬─┬ ノ( ゜-゜ノ)", "¯\\_(ツ)_/¯")

fun mapOToOwO(input: Word): Word {
    val replacement = if (Random.nextInt(2) > 0) {
        "owo"
    } else {
        "o"
    }
    return input.replace(O_TO_OWO, replacement)
}

fun mapEwToUwu(input: Word): Word {
    return input.replace(EW_TO_UWU, "uwu")
}

fun mapHeyToHay(input: Word): Word {
    return input.replace(HEY_TO_HAY, "$1ay")
}

fun mapDeadToDed(input: Word): Word {
    return input
        .replace(DEAD_TO_DED_UPPER, "Ded")
        .replace(DEAD_TO_DED_LOWER, "ded")
}

fun mapNVowelTToNd(input: Word): Word {
    return input.replace(N_VOWEL_T_TO_ND, "nd")
}

fun mapReadToWead(input: Word): Word {
    return input
        .replace(READ_TO_WEAD_UPPER, "Wead")
        .replace(READ_TO_WEAD_LOWER, "wead")
}

fun mapBracketToStarTrails(input: Word): Word {
    return input
        .replace(BRACKETS_TO_STARTRAILS_FORE, "｡･:*:･ﾟ★,｡･:*:･ﾟ☆")
        .replace(BRACKETS_TO_STARTRAILS_REAR, "☆ﾟ･:*:･｡,★ﾟ･:*:･｡")
}

fun mapPeriodCommaExclamationSemicolonToKaomojis(input: Word): Word {
    return input.replace(PERIOD_COMMA_EXCLAMATION_SEMICOLON_TO_KAOMOJIS_FIRST, fun (): String {
        return FACES.random()
    }, false)
        .replace(PERIOD_COMMA_EXCLAMATION_SEMICOLON_TO_KAOMOJIS_SECOND, fun (): String {
            return FACES.random()
        }, false)
}

fun mapThatToDat(input: Word): Word {
    return input
        .replace(THAT_TO_DAT_LOWER, "dat")
        .replace(THAT_TO_DAT_UPPER, "Dat")
}

fun mapThToF(input: Word): Word {
    return input.replace(TH_TO_F_LOWER, "f")
        .replace(TH_TO_F_UPPER, "F")
}

fun mapLeToWal(input: Word): Word {
    return input.replace(LE_TO_WAL, "wal")
}

fun mapVeToWe(input: Word): Word {
    return input.replace(VE_TO_WE_LOWER, "we")
        .replace(VE_TO_WE_UPPER, "We")
}

fun mapRyToWwy(input: Word): Word {
    return input.replace(RY_TO_WWY, "wwy")
}

fun mapROrLToW(input: Word): Word {
    return input.replace(RORL_TO_W_LOWER, "w")
        .replace(RORL_TO_W_UPPER, "W")
}


fun mapLlToWw(input: Word): Word {
    return input.replace(LL_TO_WW, "ww")
}

fun mapVowelOrRExceptOLToWl(input: Word): Word {
    return input.replace(VOWEL_OR_R_EXCEPT_O_L_TO_WL_LOWER, "wl")
        .replace(VOWEL_OR_R_EXCEPT_O_L_TO_WL_UPPER, "W$1")
}

fun mapOldToOwld(input: Word): Word {
    return input.replace(OLD_TO_OWLD_LOWER, "$1wld")
        .replace(OLD_TO_OWLD_UPPER, "OWLD")
}

fun mapOlToOwl(input: Word): Word {
    return input.replace(OL_TO_OWL_LOWER, "$1wl")
        .replace(OL_TO_OWL_UPPER, "OWL")
}

fun mapLOrROToWo(input: Word): Word {
    return input.replace(LORR_O_TO_WO_LOWER, "wo")
        .replace(LORR_O_TO_WO_UPPER, "W$1")
}

fun mapSpecificConsonantsOToLetterAndWo(input: Word): Word {
    return input
        .replace(SPECIFIC_CONSONANTS_O_TO_LETTER_AND_WO_LOWER, "$1wo")
        .replace(SPECIFIC_CONSONANTS_O_TO_LETTER_AND_WO_UPPER, fun (str1: String, str2: String): String {
            var msg = str1
            msg += if (str2.uppercase() == str2) {
                "W"
            } else {
                "w"
            }
            msg += str2
            return msg
        }, false)
}


fun mapVOrWLeToWal(input: Word): Word {
    return input.replace(VORW_LE_TO_WAL, "wal")
}

fun mapFiToFwi(input: Word): Word {
    return input.replace(FI_TO_FWI_LOWER, "$1wi")
        .replace(FI_TO_FWI_UPPER, "FWI")
}

fun mapVerToWer(input: Word): Word {
    return input.replace(VER_TO_WER, "wer")
}

fun mapPoiToPwoi(input: Word): Word {
    return input.replace(POI_TO_PWOI, "$1woi")
}

fun mapSpecificConsonantsLeToLetterAndWal(input: Word): Word {
    return input.replace(SPECIFIC_CONSONANTS_LE_TO_LETTER_AND_WAL, "$1wal")
}

fun mapConsonantsRToConsonantW(input: Word): Word {
    return input.replace(CONSONANT_R_TO_CONSONANT_W, "$1w")
}

fun mapLyToWy(input: Word): Word {
    return input.replace(LY_TO_WY_LOWER, "wy")
        .replace(LY_TO_WY_UPPER, "Wy")
}

fun mapPleToPwe(input: Word): Word {
    return input.replace(PLE_TO_PWE, "$1we")
}

fun mapNrToNw(input: Word): Word {
    return input.replace(NR_TO_NW_LOWER, "nw")
        .replace(NR_TO_NW_UPPER, "NW")
}

fun mapFucToFwuc(input: Word): Word {
    return input.replace(FUC_TO_FWUC, "$1wuc")
}

fun mapMomToMwom(input: Word): Word {
    return input.replace(MOM_TO_MWOM, "$1wom")
}

fun mapMeToMwe(input: Word): Word {
    return input.replace(ME_TO_MWE, "$1we")
}

fun mapNVowelToNy(input: Word): Word {
    return input.replace(N_VOWEL_TO_NY_FIRST, "ny$1")
        .replace(N_VOWEL_TO_NY_SECOND, "Ny$1")
        .replace(N_VOWEL_TO_NY_THIRD, "NY$1")
}

fun mapOveToUv(input: Word): Word {
    return input.replace(OVE_TO_UV_LOWER, "uv")
        .replace(OVE_TO_UV_UPPER, "UV")
}

fun mapHahaToHeheXd(input: Word): Word {
    return input.replace(HAHA_TO_HEHE_XD, "hehe xD")
}

fun mapTheToTeh(input: Word): Word {
    return input.replace(THE_TO_TEH, "$1eh")
}

fun mapYouToU(input: Word): Word {
    return input.replace(YOU_TO_U_UPPER, "U")
        .replace(YOU_TO_U_LOWER, "u")
}

fun mapTimeToTim(input: Word): Word {
    return input.replace(TIME_TO_TIM, "$1im")
}

fun mapOverToOwor(input: Word): Word {
    return input.replace(OVER_TO_OWOR, "$1wor")
}

fun mapWorseToWose(input: Word): Word {
    return input.replace(WORSE_TO_WOSE, "$1ose")
}