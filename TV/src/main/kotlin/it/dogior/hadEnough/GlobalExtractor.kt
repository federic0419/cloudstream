package com.example.extractors

import com.lagradost.cloudstream3.extractors.Extractor
import com.lagradost.cloudstream3.network.GET
import org.jsoup.Jsoup

class GlobalExtractor : Extractor() {
    override suspend fun getStreamUrl(url: String): String? {
        val response = app.get(url).document

        return when {
            url.contains("animeunity.so") -> {
                response.select("video source").attr("src")
            }
            url.contains("animeworld.so") -> {
                response.select("video source").attr("src")
            }
            url.contains("hattrick.ws") -> {
                response.select("iframe").attr("src")
            }
            url.contains("eurostreaming.restaurant") -> {
                response.select("iframe").attr("src")
            }
            url.contains("daddylive") -> {
                response.select("source[type='video/mp4']").attr("src")
            }
            url.contains("huhu.to") -> {
                response.select("video source").attr("src")
            }
            url.contains("onlineserietv.com") -> {
                response.select("video source").attr("src")
            }
            url.contains("streamingcommunity.hiphop") -> {
                response.select("source[type='video/mp4']").attr("src")
            }
            url.contains("toonitalia.green") -> {
                response.select("video source").attr("src")
            }
            url.contains("free-tv") -> {
                response.select("iframe").attr("src")
            }
            url.contains("youtube.com") -> {
                response.select("meta[itemprop='embedUrl']").attr("content")
            }
            else -> null  // Se il sito non è riconosciuto, non fa nulla
        }
    }
}
