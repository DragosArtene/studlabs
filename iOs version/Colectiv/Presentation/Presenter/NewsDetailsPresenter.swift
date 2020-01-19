//
//  NewsDetailsPresenter.swift
//  Colectiv
//
//  Created by Lobont Andrei on 19/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class NewsDetailsPresenter {
    private weak var view: NewsDetailsView?
    private weak var navigation: NewsDetailsNavigation?
    private var news: News
    
    init(view: NewsDetailsView, navigation: NewsDetailsNavigation, news: News) {
        self.view = view
        self.navigation = navigation
        self.news = news
    }
    
    func viewDidLoad() {
        setupView()
    }
    
    private func setupView() {
        view?.displayImage(with: news.image)
        view?.displayHeader(with: news.headLine)
        view?.displayDescription(with: news.text)
    }
}
