//
//  ProfileViewController.swift
//  Colectiv
//
//  Created by Lobont Andrei on 18/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import UIKit

class ProfileViewController: UIViewController {
    lazy var presenter: ProfilePresenter = ProfilePresenter(view: self, navigation: self)
    
    @IBOutlet weak var profilePictureImageView: UIImageView!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var collectionView: UICollectionView!
    @IBAction func logoutButtonAction(_ sender: Any) {
        presenter.logoutPressed()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.viewDidLoad()
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        presenter.viewDidAppear()
        
        roundImage()
    }
    
    private func roundImage() {
        profilePictureImageView.layer.cornerRadius = profilePictureImageView.frame.width / 2
    }
}

extension ProfileViewController: UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return presenter.numberOfDoneQuizes()
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView
            .dequeueReusableCell(withReuseIdentifier: "ProfileCell", for: indexPath) as! ProfileCellView
        
        
        let currentQuiz = presenter.getQuizName(at: indexPath.row)
        cell.setQuiz(title: currentQuiz)
        cell.layer.borderColor = UIColor.black.cgColor
        cell.layer.borderWidth = 1
        cell.layer.cornerRadius = cell.frame.width / 3
        
        return cell
    }
}

extension ProfileViewController: UICollectionViewDelegate {
    
}

extension ProfileViewController: ProfileView {
    func reloadData() {
        collectionView.reloadData()
    }
}

extension ProfileViewController: ProfileNavigation {
    func navigateToLogin() {
        guard let viewController = UIStoryboard(name: "Login", bundle: nil).instantiateInitialViewController() as? LoginViewController else { return }
        self.navigationController?.pushViewController(viewController, animated: false)
    }
}
