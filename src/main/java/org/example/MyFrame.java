package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class MyFrame extends JFrame {
    private boolean canPlay = false;
    private MyLabel scoreLabel;
    private JProgressBar progressBar;
    MyLabel levelLabel;
    private int[] levelCups = {10, 20, 30, 40}; // тестовые значения
    private int[] upgradeCups = {15, 30};
    MyIconButton awardButton2;
    MyIconButton button1;

    private boolean award2Purchased = false;
    private boolean award3Purchased = false;
    private boolean award4Purchased = false;

    private int score;
    private int upgradeLevel;
    private int xp;
    private int level;

    JLabel catJLabel;
    ImageIcon gameOverIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/gameOver.png")));
    ImageIcon newGameIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/newGameButton.png")));
    ImageIcon closeButtonIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/closeButton.png")));

    ImageIcon upgradesIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/upgrades.png")));
    ImageIcon rulesIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/rules.png")));
    ImageIcon awardsIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awards.png")));

    ImageIcon awardsErrorIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardsError.png")));
    ImageIcon upgradesErrorIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/upgradesError.png")));

    ImageIcon awardButton20Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-2-0.png")));
    ImageIcon awardButton21Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-2-1.png")));
    ImageIcon awardButton22Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-2-2.png")));
    ImageIcon awardButton30Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-3-0.png")));
    ImageIcon awardButton31Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-3-1.png")));
    ImageIcon awardButton32Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-3-2.png")));
    ImageIcon awardButton40Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-4-0.png")));
    ImageIcon awardButton41Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-4-1.png")));
    ImageIcon awardButton42Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/awardButton-4-2.png")));

    ImageIcon upgradePC00Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/upgradePC-0-0.png")));
    ImageIcon upgradePC01Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/upgradePC-0-1.png")));
    ImageIcon upgradePC10Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/upgradePC-1-0.png")));
    ImageIcon upgradePC11Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/upgradePC-1-1.png")));
    ImageIcon upgradePC20Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/upgradePC-2-0.png")));

    ImageIcon cat10Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat-1-0.png")));
    ImageIcon cat11Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat-1-1.png")));
    ImageIcon cat20Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat-2-0.png")));
    ImageIcon cat21Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat-2-1.png")));
    ImageIcon cat30Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat-3-0.png")));
    ImageIcon cat31Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat-3-1.png")));
    ImageIcon cat40Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat-4-0.png")));
    ImageIcon cat41Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat-4-1.png")));

    ImageIcon button1Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/button1.png")));
    ImageIcon button1wBadgeIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/button1wBadge.png")));
    Font moloko48, moloko36, moloko32, moloko20;

    public MyFrame() {
        score = 0;
        xp = 0;
        upgradeLevel = 1;
        level = 1;

        try {
            InputStream inputStream = Main.class.getResourceAsStream("/fonts/MOLOKO_by_Weekends.otf");
            moloko48 = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(48f);
            inputStream = Main.class.getResourceAsStream("/fonts/MOLOKO_by_Weekends.otf");
            moloko36 = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(36f);
            inputStream = Main.class.getResourceAsStream("/fonts/MOLOKO_by_Weekends.otf");
            moloko32 = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(32f);
            inputStream = Main.class.getResourceAsStream("/fonts/MOLOKO_by_Weekends.otf");
            moloko20 = Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(20f);
        } catch (FontFormatException | IOException ex) {
            throw new RuntimeException(ex);
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(moloko36);
        ge.registerFont(moloko32);
        ge.registerFont(moloko20);

        ImageIcon catIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/cat.png")));
        ImageIcon labelIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/label.png")));
        ImageIcon playButtonIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/playButton.png")));
        ImageIcon progressBarIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/progressBar.png")));


        ImageIcon button2Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/button2.png")));
        ImageIcon button3Icon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/images/button3.png")));

        getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(null);
        getContentPane().setPreferredSize(new Dimension(390, 844));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("IT KOTIK");

        JLabel jLabel = new JLabel(labelIcon);
        getContentPane().add(jLabel);
        jLabel.setBounds(44, 68, labelIcon.getIconWidth(), labelIcon.getIconHeight());
        jLabel.setVisible(true);

        // счет
        scoreLabel = new MyLabel("Счет: " + score);
        getContentPane().add(scoreLabel);
        scoreLabel.setBounds(136, 156, 119, 26);
        scoreLabel.setFont(moloko36);
        scoreLabel.setVisible(false);

        // Progress Bar
        progressBar = new JProgressBar(0, levelCups[level - 1]);
        progressBar.setStringPainted(true);
        getContentPane().add(progressBar);
        progressBar.setBounds(68, 203, 254, 18);
        progressBar.setFont(moloko20);
        progressBar.setString(xp + " / " + progressBar.getMaximum());
        progressBar.setOpaque(false);
        progressBar.setBorderPainted(false);
        progressBar.setVisible(false);

        // Фон Progress Bar'а
        JLabel progressBarLabel = new JLabel(progressBarIcon);
        getContentPane().add(progressBarLabel);
        progressBarLabel.setBounds(44, 188, progressBarIcon.getIconWidth(), progressBarIcon.getIconHeight());
        progressBarLabel.setVisible(false);


        // уровень
        levelLabel = new MyLabel("Ур: " + level);
        getContentPane().add(levelLabel);
        levelLabel.setBounds(173, 241, 44, 37);
        levelLabel.setFont(moloko32);
        levelLabel.setVisible(false);

        catJLabel = new JLabel(cat10Icon);
        getContentPane().add(catJLabel);
        catJLabel.setBounds(0, 292, catIcon.getIconWidth(), catIcon.getIconHeight());
        catJLabel.setVisible(true);

        // button1
        button1 = new MyIconButton(button1Icon);
        getContentPane().add(button1);
        button1.setBounds(22, 614, button1Icon.getIconWidth(), button1Icon.getIconHeight());
        button1.setVisible(false);
        button1.addActionListener(e -> {
            openAwardsWindow();
        });

        // button2
        MyIconButton button2 = new MyIconButton(button2Icon);
        getContentPane().add(button2);
        button2.setBounds(140, 614, button1Icon.getIconWidth(), button1Icon.getIconHeight());
        button2.setVisible(false);
        button2.addActionListener(e -> {
            openUpgradesWindow();
        });

        // button3
        MyIconButton button3 = new MyIconButton(button3Icon);
        getContentPane().add(button3);
        button3.setBounds(258, 614, button1Icon.getIconWidth(), button1Icon.getIconHeight());
        button3.setVisible(false);
        button3.addActionListener(e -> {
            openRulesWindow();
        });


        MyIconButton playButton = new MyIconButton(playButtonIcon);
        getContentPane().add(playButton);
        playButton.setBounds(15, 669, playButtonIcon.getIconWidth(), playButtonIcon.getIconHeight());
        playButton.setVisible(true);

//        JButton playJButton = new JButton("Играть!");
//        JLabel levelJLabel = new JLabel("0");
//        getContentPane().add(playJButton);
//        playJButton.setBounds(20, 674, 350, 100);

        setLocationRelativeTo(null);
        setVisible(true);

        playButton.addActionListener(e -> {
            scoreLabel.setVisible(true);
            progressBar.setVisible(true);
            progressBarLabel.setVisible(true);
            levelLabel.setVisible(true);
            button1.setVisible(true);
            button2.setVisible(true);
            button3.setVisible(true);

            canPlay = true;
            playButton.setVisible(false);
            getContentPane().revalidate();
            getContentPane().repaint();
        });

        catJLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (canPlay) {
                    if (catJLabel.getIcon() == cat10Icon) {
                        catJLabel.setIcon(cat11Icon);
                    } else if (catJLabel.getIcon() == cat11Icon) {
                        catJLabel.setIcon(cat10Icon);
                    } else if (catJLabel.getIcon() == cat20Icon) {
                        catJLabel.setIcon(cat21Icon);
                    } else if (catJLabel.getIcon() == cat21Icon) {
                        catJLabel.setIcon(cat20Icon);
                    } else if (catJLabel.getIcon() == cat30Icon) {
                        catJLabel.setIcon(cat31Icon);
                    } else if (catJLabel.getIcon() == cat31Icon) {
                        catJLabel.setIcon(cat30Icon);
                    } else if (catJLabel.getIcon() == cat40Icon) {
                        catJLabel.setIcon(cat41Icon);
                    } else if (catJLabel.getIcon() == cat41Icon) {
                        catJLabel.setIcon(cat40Icon);
                    }
                    score++;
                    scoreLabel.setText("Счет: " + score);
                    xp += upgradeLevel;
                    progressBar.setValue(xp);
                    progressBar.setString(xp + " / " + progressBar.getMaximum());

                    // Победа
                    if (xp >= levelCups[levelCups.length - 1]) {
                        openGameOverWindow();
                    } else if (xp >= levelCups[level - 1]) {
                        level++;
                        if (level < 5) {
                            button1.setIcon(button1wBadgeIcon);
                        }
                        levelLabel.setText("Ур: " + level);
                        xp = xp - levelCups[level - 2];
                        progressBar.setValue(xp);
                        progressBar.setMaximum(levelCups[level - 1]);
                        progressBar.setString(xp + " / " + progressBar.getMaximum());
                    }
                }
            }
        });
    }


    private void openGameOverWindow() {
        JDialog dialog = new JDialog();
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.getContentPane().setLayout(null);
        dialog.getContentPane().setPreferredSize(new Dimension(368, 228));
        dialog.pack();
        dialog.setModal(true);
        dialog.setTitle("Игра пройдена");

        JLabel gameOverLabel = new JLabel(gameOverIcon);
        dialog.getContentPane().add(gameOverLabel);
        gameOverLabel.setBounds(30, 45, gameOverIcon.getIconWidth(), gameOverIcon.getIconHeight());
        gameOverLabel.setVisible(true);

        MyIconButton closeButton = new MyIconButton(newGameIcon);
        dialog.getContentPane().add(closeButton);
        closeButton.setBounds(4, 114, newGameIcon.getIconWidth(), newGameIcon.getIconHeight());
        closeButton.setVisible(true);

        closeButton.addActionListener(e -> {
            score = 0;
            scoreLabel.setText("Счет: " + score);
            level = 1;
            levelLabel.setText("Ур: " + level);
            xp = 0;
            upgradeLevel = 1;
            progressBar.setValue(xp);
            progressBar.setMaximum(levelCups[level - 1]);
            progressBar.setString(xp + " / " + progressBar.getMaximum());

            award2Purchased = false;
            award3Purchased = false;
            award4Purchased = false;

            catJLabel.setIcon(cat10Icon);
            button1.setIcon(button1Icon);
            dialog.dispose();
        });
        dialog.add(closeButton);

        dialog.setLocationRelativeTo(null); // Центрируем окно
        dialog.setVisible(true); // Показываем модальное окно
    }


    private void openAwardsWindow() {
        JDialog dialog = new JDialog();
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.getContentPane().setLayout(null);
        dialog.getContentPane().setPreferredSize(new Dimension(368, 620));
        dialog.pack();
        dialog.setModal(true);
        dialog.setTitle("Награды");

        JLabel jLabel = new JLabel(awardsIcon);
        dialog.getContentPane().add(jLabel);
        jLabel.setBounds(56, 39, awardsIcon.getIconWidth(), awardsIcon.getIconHeight());
        jLabel.setVisible(true);


        awardButton2 = new MyIconButton(awardButton20Icon);
        if (level >= 2) {
            if (!award2Purchased) {
                awardButton2.setIcon(awardButton21Icon);
            } else {
                awardButton2.setIcon(awardButton22Icon);
            }
        }
        dialog.getContentPane().add(awardButton2);
        awardButton2.setBounds(4, 131, awardButton20Icon.getIconWidth(), awardButton20Icon.getIconHeight());
        awardButton2.setVisible(true);
        awardButton2.addActionListener(e -> {
            if (level >= 2 && !award2Purchased) {
                awardButton2.setIcon(awardButton22Icon);
                award2Purchased = true;
                catJLabel.setIcon(cat20Icon);
            } else if (level < 2) {
                openAwardsErrorWindow();
            }
        });


        MyIconButton awardButton3 = new MyIconButton(awardButton30Icon);
        if (level >= 3) {
            if (!award3Purchased) {
                awardButton3.setIcon(awardButton31Icon);
            } else {
                awardButton3.setIcon(awardButton32Icon);
            }
        }
        dialog.getContentPane().add(awardButton3);
        awardButton3.setBounds(4, 241, awardButton30Icon.getIconWidth(), awardButton30Icon.getIconHeight());
        awardButton3.setVisible(true);
        awardButton3.addActionListener(e -> {
            if (level >= 3 && !award3Purchased && award2Purchased) {
                awardButton3.setIcon(awardButton32Icon);
                award3Purchased = true;
                catJLabel.setIcon(cat30Icon);
            } else if (level < 3) {
                openAwardsErrorWindow();
            }
        });


        MyIconButton awardButton4 = new MyIconButton(awardButton40Icon);
        if (level >= 4) {
            if (!award4Purchased) {
                awardButton4.setIcon(awardButton41Icon);
            } else {
                awardButton4.setIcon(awardButton42Icon);
            }
        }
        dialog.getContentPane().add(awardButton4);
        awardButton4.setBounds(4, 351, awardButton40Icon.getIconWidth(), awardButton40Icon.getIconHeight());
        awardButton4.setVisible(true);
        awardButton4.addActionListener(e -> {
            if (level >= 4 && !award4Purchased && award3Purchased && award2Purchased) {
                awardButton4.setIcon(awardButton42Icon);
                award4Purchased = true;
                catJLabel.setIcon(cat40Icon);
            } else if (level < 4) {
                openAwardsErrorWindow();
            }
        });


        MyIconButton closeButton = new MyIconButton(closeButtonIcon);
        dialog.getContentPane().add(closeButton);
        closeButton.setBounds(4, 506, closeButtonIcon.getIconWidth(), closeButtonIcon.getIconHeight());
        closeButton.setVisible(true);
        closeButton.addActionListener(e -> {
            if (awardButton2.getIcon() != awardButton21Icon
            && awardButton3.getIcon() != awardButton31Icon
            && awardButton4.getIcon() != awardButton41Icon) {
                button1.setIcon(button1Icon);
            }
            dialog.dispose();
        });

        dialog.setLocationRelativeTo(null); // Центрируем окно
        dialog.setVisible(true); // Показываем модальное окно
    }

    private void openUpgradesWindow() {
        JDialog dialog = new JDialog();
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.getContentPane().setLayout(null);
        dialog.getContentPane().setPreferredSize(new Dimension(368, 470));
        dialog.pack();
        dialog.setModal(true);
        dialog.setTitle("Улучшения");

        JLabel upgradesLabel = new JLabel(upgradesIcon);
        dialog.getContentPane().add(upgradesLabel);
        upgradesLabel.setBounds(28, 30, upgradesIcon.getIconWidth(), upgradesIcon.getIconHeight());
        upgradesLabel.setVisible(true);

        MyLabel localScoreLabel = new MyLabel("У Вас " + score + " очков");
        dialog.getContentPane().add(localScoreLabel);
        localScoreLabel.setBounds(66, 127, 236, 43);
        localScoreLabel.setFont(moloko36);
        localScoreLabel.setVisible(true);

        MyIconButton upgradePCButton = new MyIconButton(upgradePC00Icon);
        if (upgradeLevel == 1) {
            if (score >= upgradeCups[upgradeLevel - 1]) {
                upgradePCButton.setIcon(upgradePC01Icon);
            } else {
                upgradePCButton.setIcon(upgradePC00Icon);
            }
        } else if (upgradeLevel == 2) {
            if (score >= upgradeCups[upgradeLevel - 1]) {
                upgradePCButton.setIcon(upgradePC11Icon);
            } else {
                upgradePCButton.setIcon(upgradePC10Icon);
            }
        } else if (upgradeLevel == 3) {
            upgradePCButton.setIcon(upgradePC20Icon);
        }
        dialog.getContentPane().add(upgradePCButton);
        upgradePCButton.setBounds(4, 208, upgradePC00Icon.getIconWidth(), upgradePC00Icon.getIconHeight());
        upgradePCButton.setVisible(true);
        upgradePCButton.addActionListener(e -> {
            if (upgradeLevel < 3) {
                if (score >= upgradeCups[upgradeLevel - 1]) {
                    score = score - upgradeCups[upgradeLevel - 1];
                    scoreLabel.setText("Счет: " + score);
                    localScoreLabel.setText("У Вас " + score + " очков");
                    upgradeLevel++;
                    if (upgradeLevel == 2) {
                        upgradePCButton.setIcon(upgradePC10Icon);
                    } else if (upgradeLevel == 3) {
                        upgradePCButton.setIcon(upgradePC20Icon);
                    }
                } else {
                    openUpgradesErrorWindow();
                }
            }
        });

        MyIconButton closeButton = new MyIconButton(closeButtonIcon);
        dialog.getContentPane().add(closeButton);
        closeButton.setBounds(4, 356, closeButtonIcon.getIconWidth(), closeButtonIcon.getIconHeight());
        closeButton.setVisible(true);
        closeButton.addActionListener(e -> dialog.dispose());

        dialog.setLocationRelativeTo(null); // Центрируем окно
        dialog.setVisible(true); // Показываем модальное окно
    }

    private void openRulesWindow() {
        JDialog dialog = new JDialog();
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.getContentPane().setLayout(null);
        dialog.getContentPane().setPreferredSize(new Dimension(368, 734));
        dialog.pack();
        dialog.setModal(true);
        dialog.setTitle("Правила");

        JLabel rulesLabel = new JLabel(rulesIcon);
        dialog.getContentPane().add(rulesLabel);
        rulesLabel.setBounds(0, 0, rulesIcon.getIconWidth(), rulesIcon.getIconHeight());
        rulesLabel.setVisible(true);

        MyIconButton closeButton = new MyIconButton(closeButtonIcon);
        dialog.getContentPane().add(closeButton);
        closeButton.setBounds(4, 620, closeButtonIcon.getIconWidth(), closeButtonIcon.getIconHeight());
        closeButton.setVisible(true);
        closeButton.addActionListener(e -> dialog.dispose());

        dialog.setLocationRelativeTo(null); // Центрируем окно
        dialog.setVisible(true); // Показываем модальное окно
    }

    private void getAward() {
    }

    private void openAwardsErrorWindow() {
        JDialog dialog = new JDialog();
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.getContentPane().setLayout(null);
        dialog.getContentPane().setPreferredSize(new Dimension(368, 344));
        dialog.pack();
        dialog.setModal(true);
        dialog.setTitle("Награды");

        JLabel jLabel = new JLabel(awardsErrorIcon);
        dialog.getContentPane().add(jLabel);
        jLabel.setBounds(0, 0, awardsErrorIcon.getIconWidth(), awardsErrorIcon.getIconHeight());
        jLabel.setVisible(true);

        MyIconButton closeButton = new MyIconButton(closeButtonIcon);
        dialog.getContentPane().add(closeButton);
        closeButton.setBounds(4, 230, closeButtonIcon.getIconWidth(), closeButtonIcon.getIconHeight());
        closeButton.setVisible(true);
        closeButton.addActionListener(e -> dialog.dispose());

        dialog.setLocationRelativeTo(null); // Центрируем окно
        dialog.setVisible(true); // Показываем модальное окно
    }

    private void openUpgradesErrorWindow() {
        JDialog dialog = new JDialog();
        dialog.getContentPane().setBackground(Color.WHITE);
        dialog.getContentPane().setLayout(null);
        dialog.getContentPane().setPreferredSize(new Dimension(368, 344));
        dialog.pack();
        dialog.setModal(true);
        dialog.setTitle("Улучшения");

        MyIconButton closeButton = new MyIconButton(closeButtonIcon);
        dialog.getContentPane().add(closeButton);
        closeButton.setBounds(4, 230, closeButtonIcon.getIconWidth(), closeButtonIcon.getIconHeight());
        closeButton.setVisible(true);

        JLabel jLabel = new JLabel(upgradesErrorIcon);
        dialog.getContentPane().add(jLabel);
        jLabel.setBounds(0, 0, upgradesErrorIcon.getIconWidth(), upgradesErrorIcon.getIconHeight());
        jLabel.setVisible(true);

        closeButton.addActionListener(e -> dialog.dispose());

        dialog.setLocationRelativeTo(null); // Центрируем окно
        dialog.setVisible(true); // Показываем модальное окно
    }
}
