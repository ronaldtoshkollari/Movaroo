package com.ronalad.mavaroo.title_details.data.dto

import com.google.gson.annotations.SerializedName

data class TitleDetailsDto(
    @SerializedName("actorList")
    private val _actorDtoList: List<ActorDto>? = emptyList(),
    @SerializedName("awards")
    private val _awards: String? = "",
    @SerializedName("boxOffice")
    private val _boxOfficeDto: BoxOfficeDto? = BoxOfficeDto(),
    @SerializedName("companies")
    private val _companies: String? = "",
    @SerializedName("companyList")
    private val _companyDtoList: List<CompanyDto>? = emptyList(),
    @SerializedName("contentRating")
    private val _contentRating: String? = "",
    @SerializedName("countries")
    private val _countries: String? = "",
    @SerializedName("countryList")
    private val _countryDtoList: List<CountryDto>? = emptyList(),
    @SerializedName("directorList")
    private val _directorDtoList: List<DirectorDto>? = emptyList(),
    @SerializedName("directors")
    private val _directors: String? = "",
    @SerializedName("errorMessage")
    private val _errorMessage: String? = "",
    @SerializedName("fullTitle")
    private val _fullTitle: String? = "",
    @SerializedName("genreList")
    private val _genreDtoList: List<GenreDto>? = emptyList(),
    @SerializedName("genres")
    private val _genres: String? = "",
    @SerializedName("id")
    private val _id: String? = "",
    @SerializedName("imDbRating")
    private val _imDbRating: String? = "",
    @SerializedName("imDbRatingVotes")
    private val _imDbRatingVotes: String? = "",
    @SerializedName("image")
    private val _image: String? = "",
    @SerializedName("keywordList")
    private val _keywordList: List<String>? = emptyList(),
    @SerializedName("keywords")
    private val _keywords: String? = "",
    @SerializedName("languageList")
    private val _languageDtoList: List<LanguageDto>? = emptyList(),
    @SerializedName("languages")
    private val _languages: String? = "",
    @SerializedName("metacriticRating")
    private val _metacriticRating: String? = "",
    @SerializedName("originalTitle")
    private val _originalTitle: String? = "",
    @SerializedName("plot")
    private val _plot: String? = "",
    @SerializedName("plotLocal")
    private val _plotLocal: String? = "",
    @SerializedName("plotLocalIsRtl")
    private val _plotLocalIsRtl: Boolean? = false,
    @SerializedName("releaseDate")
    private val _releaseDate: String? = "",
    @SerializedName("runtimeMins")
    private val _runtimeMins: String? = "",
    @SerializedName("runtimeStr")
    private val _runtimeStr: String? = "",
    @SerializedName("similars")
    private val _similarTitlesDtos: List<SimilarTitlesDto>? = emptyList(),
    @SerializedName("starList")
    private val _starDtoList: List<StarDto>? = emptyList(),
    @SerializedName("stars")
    private val _stars: String? = "",
    @SerializedName("title")
    private val _title: String? = "",
    @SerializedName("type")
    private val _type: String? = "",
    @SerializedName("writerList")
    private val _writerDtoList: List<WriterDto>? = emptyList(),
    @SerializedName("writers")
    private val _writers: String? = "",
    @SerializedName("year")
    private val _year: String? = ""
) {
    val actorDtoList: List<ActorDto>
        get() = _actorDtoList ?: emptyList()

    val awards
        get() = _awards ?: ""

    val boxOfficeDto: BoxOfficeDto
        get() = _boxOfficeDto ?: BoxOfficeDto()

    val companies: String
        get() = _companies ?: ""

    val companyDtoList: List<CompanyDto>
        get() = _companyDtoList ?: emptyList()

    val contentRating: String
        get() = _contentRating ?: ""

    val countries: String
        get() = _countries ?: ""

    val countryDtoList: List<CountryDto>
        get() = _countryDtoList ?: emptyList()

    val directorDtoList: List<DirectorDto>
        get() = _directorDtoList ?: emptyList()

    val directors: String
        get() = _directors ?: ""

    val errorMessage: String
        get() = _errorMessage ?: ""

    val fullTitle: String
        get() = _fullTitle ?: ""

    val genreDtoList: List<GenreDto>
        get() = _genreDtoList ?: emptyList()

    val genres: String
        get() = _genres ?: ""

    val id: String
        get() = _id ?: ""

    val imDbRating: String
        get() = _imDbRating ?: ""

    val imDbRatingVotes: String
        get() = _imDbRatingVotes ?: ""

    val image: String
        get() = _image ?: ""

    val keywordList: List<String>
        get() = _keywordList ?: emptyList()

    val keywords: String
        get() = _keywords ?: ""

    val languageDtoList: List<LanguageDto>
        get() = _languageDtoList ?: emptyList()

    val languages: String
        get() = _languages ?: ""

    val metacriticRating: String
        get() = _metacriticRating ?: ""


    val originalTitle: String
        get() = _originalTitle ?: ""

    val plot: String
        get() = _plot ?: ""

    val plotLocal: String
        get() = _plotLocal ?: ""

    val plotLocalIsRtl: Boolean
        get() = _plotLocalIsRtl ?: false

    val releaseDate: String
        get() = _releaseDate ?: ""

    val runtimeMins: String
        get() = _runtimeMins ?: ""

    val runtimeStr: String
        get() = _runtimeStr ?: ""

    val similarTitlesDtos: List<SimilarTitlesDto>
        get() = _similarTitlesDtos ?: emptyList()

    val starDtoList: List<StarDto>
        get() = _starDtoList ?: emptyList()

    val stars: String
        get() = _stars ?: ""

    val title: String
        get() = _title ?: ""

    val type: String
        get() = _type ?: ""

    val writerDtoList: List<WriterDto>
        get() = _writerDtoList ?: emptyList()

    val writers: String
        get() = _writers ?: ""

    val year: String
        get() = _year ?: ""
}