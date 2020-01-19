//
//  NewsDetailsViewController.swift
//  Colectiv
//
//  Created by Lobont Andrei on 19/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class NewsDetailsViewController: UIViewController {
    var presenter: NewsDetailsPresenter?
    
    @IBOutlet weak var newsImageView: UIImageView!
    @IBOutlet weak var newsHeadlineLabel: UILabel!
    @IBOutlet weak var newsTextLabel: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter?.viewDidLoad()
        
    }
}

extension NewsDetailsViewController: NewsDetailsView {
    func displayImage(with image: String) {
        
    }
    
    func displayHeader(with title: String) {
        newsHeadlineLabel.text = title
    }
    
    func displayDescription(with descriptiom: String) {
        newsTextLabel.text = descriptiom
    }
    
    
}

extension NewsDetailsViewController: NewsDetailsNavigation {
    
}
