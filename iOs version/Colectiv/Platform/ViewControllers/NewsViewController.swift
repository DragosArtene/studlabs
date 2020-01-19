//
//  NewsViewController.swift
//  Colectiv
//
//  Created by Lobont Andrei on 19/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class NewsViewController: UIViewController {
    lazy var presenter: NewsPresenter = NewsPresenter(view: self, navigation: self)
    
    @IBOutlet weak var headLineImageView: UIImageView!
    @IBOutlet weak var headLineTitle: UILabel!
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.viewDidLoad()
        
    }
}

extension NewsViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return presenter.getNumberOfNews()
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "NewsCell") as? NewsCellView else {
            return UITableViewCell()
        }
        
        let currentNews = presenter.getNews(at: indexPath.row)
        cell.setCell(with: currentNews.headLine, description: currentNews.description, and: "labels")
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        presenter.newsAt(index: indexPath.row)
        tableView.deselectRow(at: indexPath, animated: true)
    }
}

extension NewsViewController: UITableViewDelegate {
    
}

extension NewsViewController: NewsView {
    
}

extension NewsViewController: NewsNavigation {
    func navigateToNews(with news: News) {
        guard let viewController = UIStoryboard(name: "News", bundle: nil).instantiateViewController(identifier: "NewsDetails") as? NewsDetailsViewController else { return }
        let presenter: NewsDetailsPresenter = NewsDetailsPresenter(view: viewController, navigation: viewController, news: news)
        viewController.presenter = presenter
        
        self.present(viewController, animated: true, completion: nil)
    }
}
