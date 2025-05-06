package com.example.tradebolt.service;

import com.example.tradebolt.Modal.Coin;
import com.example.tradebolt.Modal.User;
import com.example.tradebolt.Modal.Watchlist;

public interface WatchlistService {

    Watchlist findUserWatchlist(Long userId) throws Exception;
    Watchlist createWatchlist(User user);
    Watchlist findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
}
