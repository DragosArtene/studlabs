//
//  MainViewController.swift
//  Colectiv
//
//  Created by Andrei Lobont on 13/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {
    lazy private var presenter: MainPresenter = MainPresenter(navigation: self)
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.viewDidLoad()
        
    }
}

extension MainViewController: MainNavigation {
    func navigateToLogin() {
        guard let viewController = UIStoryboard(name: "Login", bundle: nil).instantiateInitialViewController() as? LoginViewController else { return }
        self.navigationController?.pushViewController(viewController, animated: false)
    }
    
    func navigateToHome() {
        guard let viewController = UIStoryboard(name: "Home", bundle: nil).instantiateInitialViewController() as? HomeViewController else { return }
        self.navigationController?.pushViewController(viewController, animated: false)
    }
    
    private func addScreen(of viewController: UIViewController) {
        addChild(viewController)
        viewController.view.translatesAutoresizingMaskIntoConstraints = false
        view.addSubview(viewController.view)
        viewController.view.leadingAnchor.constraint(equalTo: view.leadingAnchor).isActive = true
        viewController.view.trailingAnchor.constraint(equalTo: view.trailingAnchor).isActive = true
        viewController.view.topAnchor.constraint(equalTo: view.topAnchor).isActive = true
        viewController.view.bottomAnchor.constraint(equalTo: view.bottomAnchor).isActive = true
    }
}
